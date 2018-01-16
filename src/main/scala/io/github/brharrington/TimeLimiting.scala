package io.github.brharrington

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

import com.netflix.servo.util.TimeLimiter
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.TearDown
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Thread)
class TimeLimiting {

  private val executor = Executors.newFixedThreadPool(1)
  private val limiter = new TimeLimiter(executor)

  private val value = new AtomicLong()

  @Benchmark
  def limit(bh: Blackhole): Unit = {
    val result = limiter.callWithTimeout(() => value.incrementAndGet(), 1, TimeUnit.SECONDS)
    bh.consume(result)
  }

  @TearDown
  def cleanup(): Unit = {
    executor.shutdown()
  }

}