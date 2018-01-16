package io.github.brharrington

import java.util.concurrent.atomic.AtomicLong

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Thread)
class AtomicLongUpdate {

  private val value = new AtomicLong()

  @Benchmark
  def incrementAndGet(bh: Blackhole): Unit = {
    bh.consume(value.incrementAndGet())
  }

  @Benchmark
  def addAndGet(bh: Blackhole): Unit = {
    bh.consume(value.addAndGet(42))
  }

  @Benchmark
  def get(bh: Blackhole): Unit = {
    bh.consume(value.get())
  }

}