package io.github.brharrington

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Thread)
class NanoTime {

  @Benchmark
  def nanoTime(bh: Blackhole): Unit = {
    bh.consume(System.nanoTime())
  }

}