package org.example;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;

@State(Scope.Benchmark)
public class TestStreamPerformance {
    static final SorterNoStream sorterNoStream = new SorterNoStream();
    static final SorterStream sorterStream = new SorterStream();

    @Param({"100", "200"})
    int volume;

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.Throughput)
    public void runSortingNoStream() {
        Element[] elements = Element.makeElements(volume, volume);
        sorterNoStream.sort(elements);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.Throughput)
    public void runSortingStream() {
        Element[] elements = Element.makeElements(volume, volume);
        sorterStream.sort(elements);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
