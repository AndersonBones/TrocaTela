package br.edu.utfpr.trocatela

import android.view.View
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.hasToString
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.startsWith

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("br.edu.utfpr.trocatela", appContext.packageName)

        onView(withId(R.id.btLancamento)).perform(ViewActions.click())

        onView(withId(R.id.btListar)).perform(ViewActions.click())

        onView(withId(R.id.lvProdutos)).check(matches(isDisplayed()))

        onData(
            allOf(
                instanceOf(String::class.java),
                hasToString(startsWith("Fanta"))
            )
        ).inAdapterView(withId(R.id.lvProdutos))
            .perform(ViewActions.click())



        onView(withId(R.id.etQtd)).perform(ViewActions.typeText("3")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.etValor)).perform(ViewActions.typeText("12.25")).perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btConfirmar)).perform(ViewActions.click())



    }



}