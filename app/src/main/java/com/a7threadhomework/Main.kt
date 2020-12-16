package com.a7threadhomework

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

/**Створити проект, де буде 4 потока, які повинні постійно збільшувати counter кожних 10 мс.
 *  При цьому має бути 5-й поток, який буде виводити значення counter в консоль кожних 1000 мс.
 *  Ви самі повинні вибрати спосіб уникнення race condition.
 *  */

var counter2 : AtomicLong = AtomicLong(0)

fun increaseCounter2() {
    counter2.incrementAndGet()
}

fun main() {

    val scheduledEx = Executors.newScheduledThreadPool(5)

    scheduledEx.scheduleAtFixedRate({println(counter2)}, 0, 1, TimeUnit.SECONDS)
    scheduledEx.scheduleAtFixedRate({increaseCounter2()}, 0 , 10, TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate({increaseCounter2()}, 0 , 10, TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate({increaseCounter2()}, 0 , 10, TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate({increaseCounter2()}, 0 , 10, TimeUnit.MILLISECONDS)

}
