package com.acme.generator

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import com.acme.shared.MonthUtil
import org.junit.Test

internal class MonthUtilTest {

    @Test
    fun `should add one zero to January 1`() {
        val monthAsString = MonthUtil.padMonth(1)
        expect(monthAsString).toBe("01")
    }

    @Test
    fun `should not add any zero to October 10`() {
        val monthAsString = MonthUtil.padMonth(10)
        expect(monthAsString).toBe("10")
    }


}