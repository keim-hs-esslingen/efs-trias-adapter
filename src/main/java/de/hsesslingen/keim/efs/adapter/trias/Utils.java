/*
 * MIT License
 * 
 * Copyright (c) 2020 Hochschule Esslingen
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE. 
 */
package de.hsesslingen.keim.efs.adapter.trias;

import de.vdv.trias.InternationalText;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

/**
 *
 * @author keim
 */
public class Utils {

    private static final Logger logger = getLogger(Utils.class);

    private static final Pattern EN_LOCALE = Pattern.compile("en|en[\\-_]en|en[\\-_]us|en[\\-_]gb");

    /**
     * Simply runs the getter and returns the result but catches
     * NullPointerExceptions. In that case, null is returned.
     *
     * @param <T>
     * @param getter
     * @return
     */
    public static <T> T nullsafe(Supplier<T> getter) {
        try {
            return getter.get();
        } catch (NullPointerException ex) {
            logger.debug("Caught null pointer exception in nullsafe(...): {}", ex.getMessage());
            return null;
        }
    }

    /**
     * Extracts the most preffered text value of the given list of
     * {@link InternationalText}.
     * <p>
     * The persued order is:
     * <ol>
     * <li>Text in language of client (given by clientLocale)</li>
     * <li>Text in english</li>
     * <li>First text in list</li>
     * <li>{@code null}</li>
     * </ol>
     *
     * @param texts
     * @param clientLocale If null, the client locale preferation is ignored.
     * @return
     */
    public static String extract(List<InternationalText> texts, String clientLocale) {
        if (texts.isEmpty()) {
            return null;
        }
        String firstText = firstAsOptional(texts).map(first -> first.getText()).orElse(null);
        String clientLocaleText = null;
        String englishText = null;
        for (InternationalText intText : texts) {
            String lang = intText.getLanguage();
            if (clientLocale != null && clientLocale.equalsIgnoreCase(lang)) {
                clientLocaleText = intText.getText();
            } else if ("en".equalsIgnoreCase(lang) || EN_LOCALE.matcher(lang).matches()) {
                englishText = intText.getText();
            }
        }
        String choice = clientLocaleText != null ? clientLocaleText : englishText != null ? englishText : firstText;
        return choice;
    }

    /**
     * Uses {@link TriasModelUtils#extract(List, String)} with a
     * {@code clientLocale} of null.
     *
     * @param texts
     * @return
     */
    public static String extract(List<InternationalText> texts) {
        return extract(texts, null);
    }

    public static <C extends Collection> void ifNotEmpty(C collection, Consumer<C> consumer) {
        if (collection != null && !collection.isEmpty()) {
            consumer.accept(collection);
        }
    }

    /**
     * Returns the first element of the list, or null, if that list is empty.
     *
     * @param <T>
     * @param list
     * @return
     */
    public static <T> Optional<T> firstAsOptional(List<T> list) {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }

    /**
     * If {@link obj} is not {@code null}, the given function is applied with
     * {@link obj} as argument.
     *
     * @param <T>
     * @param obj
     * @param func
     */
    public static <T> void ifPresent(T obj, Consumer<T> func) {
        if (obj != null) {
            func.accept(obj);
        }
    }

    /**
     * Returns the first element of the list, or null, if that list is empty.
     *
     * @param <T>
     * @param list
     * @return
     */
    public static <T> T firstOf(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * Applies the given {@link Consuer} to the first element of {@link list},
     * if {@link list} is not empty.
     *
     * @param <T>
     * @param list
     * @param consumer
     * @return
     */
    public static <T> T firstOf(List<T> list, Consumer<T> consumer) {
        if (!list.isEmpty()) {
            T first = list.get(0);
            consumer.accept(first);
            return first;
        }
        return null;
    }

}
