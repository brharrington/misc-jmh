package io.github.brharrington

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Thread)
class CurrentTimeMillis {

  @Benchmark
  def currentTimeMillis(bh: Blackhole): Unit = {
    bh.consume(System.currentTimeMillis())
  }

}