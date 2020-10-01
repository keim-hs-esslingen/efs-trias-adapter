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

import de.vdv.trias.Trias;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author keim
 */
public class ContinuingTriasRequests {

    private TriasProxy proxy;
    private Trias request;
    private Function<Trias, Boolean> prepareNext;
    private Comparator<Trias> comparator = null;
    private Trias previousResponse = null;
    private boolean hasNext = true;
    private ContinuingTriasSpliterator spliterator = new ContinuingTriasSpliterator();

    public ContinuingTriasRequests(TriasProxy proxy, Trias request, Function<Trias, Boolean> prepareNext) {
        this.proxy = proxy;
        this.request = request;
        this.prepareNext = prepareNext;
    }

    public Stream<Trias> stream() {
        return StreamSupport.stream(spliterator, false);
    }

    private class ContinuingTriasSpliterator implements Spliterator<Trias> {

        @Override
        public boolean tryAdvance(Consumer<? super Trias> action) {
            if (hasNext) {
                previousResponse = proxy.send(request);
                hasNext = prepareNext.apply(previousResponse);
                action.accept(previousResponse);
                return true;
            }

            return false;
        }

        @Override
        public Spliterator<Trias> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return Long.MAX_VALUE; // Unkown size!
        }

        @Override
        public Comparator<? super Trias> getComparator() {
            return comparator;
        }

        @Override
        public int characteristics() {
            var characteristics = Spliterator.DISTINCT | Spliterator.IMMUTABLE | Spliterator.ORDERED;

            if (comparator != null) {
                characteristics |= Spliterator.SORTED;
            }

            return characteristics;
        }

    }
}
