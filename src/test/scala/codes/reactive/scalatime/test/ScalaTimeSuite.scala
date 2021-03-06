/******************************************************************
 * See the NOTICE file distributed with this work for additional  *
 * information regarding Copyright ownership.  The author/authors *
 * license this file to you under the terms of the Apache License *
 * Version 2.0 (the "License"); you may not use this file except  *
 * in compliance with the License.  You may obtain a copy of the  *
 * License at:                                                    *
 *                                                                *
 *     http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                                *
 * Unless required by applicable law or agreed to in writing,     *
 * software distributed under the License is distributed on an    *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,   *
 * either express or implied.  See the License for the specific   *
 * language governing permissions and limitations under the       *
 * License.                                                       *
 ******************************************************************/

package codes.reactive.scalatime.test

import codes.reactive.scalatime.impl.TimeSupport.TemporalQuery
import org.scalatest.{FreeSpec, Matchers}

import util.Try


class ScalaTimeSuite extends FreeSpec with Matchers {

  "code examples provided by documentation are current." - {
    import codes.reactive.scalatime._
    import Scalatime._
    "readme / rootdoc examples" - {

      "create a Duration from a Long" in {
        def duration = {
          10L minutes
        }
        duration shouldBe DurationTestHelpers.minutes(10L)
      }

      "create a Period from a Long" in {
        def period = {
          10 days
        }
        period shouldBe PeriodTestHelpers.days(10)
      }

      "Try to create a LocalDate" in {
        val localDate = LocalDate.of(2014, 6, 7)
        localDate.getYear shouldBe 2014
        localDate.getMonth shouldBe Month.June
        localDate.getDayOfMonth shouldBe 7
      }

      "Create a ZonedDateTime from the current UTC instant" in {
        val zonedDateTime = ZonedDateTime()
        zonedDateTime.getZone shouldBe ZoneId.UTC
      }

      "Obtains a default TemporalQuery for ZoneId" in {
        val query = TemporalQuery.zone
        (query |> ZonedDateTime()) shouldBe ZoneId.UTC
      }

      "Create a Duration from the sum of Durations" in {
        val duration = {
          10L minutes
        }
        val otherDuration = {
          1L minute
        }

        (duration + otherDuration) shouldBe (11L minutes)
      }

      "Obtain a Temporal from a TemporalAmount added to a Period" in {
        val period = {
          2 weeks
        }
        val localDate = LocalDate.of(2014, 6, 7)

        (period <<+ localDate) shouldBe LocalDate.of(2014, 6, 21)
        (localDate + period) shouldBe LocalDate.of(2014, 6, 21)
      }


      "Obtain a Temporal from a TemporalAmount subtracted from a Period" in {
        val period = {
          2 weeks
        }
        val localDate = LocalDate.of(2014, 6, 7)

        (period <<- localDate) shouldBe LocalDate.of(2014, 5, 24)
        (localDate - period) shouldBe LocalDate.of(2014, 5, 24)
      }
    }

    "control.Catcher api doc" - {
      import codes.reactive.scalatime._
      val catchAllLocalDate = control.Catcher.all(_ => LocalDate.of(2014, 9, 14))
      val recovered = Try(LocalDate.parse(")(&#)(@*@&#%@#%@#%)")).recover(catchAllLocalDate)
      recovered.map(_ shouldBe LocalDate.of(2014, 9, 14))
    }

    "Clock api doc" - {
      import codes.reactive.scalatime._
      val utcClock = Clock()
      val inst = Instant()
      val fixed = Clock.fixed(inst)
      utcClock.getZone shouldBe ZoneId.UTC
      fixed.instant() shouldBe inst
    }

    "Duration api doc" - {
      import codes.reactive.scalatime._
      val utcClock = Clock()
      val inst = Instant()
      val fixed = Clock.fixed(inst)
      utcClock.getZone shouldBe ZoneId.UTC
      fixed.instant() shouldBe inst
    }

  }

  "'simple' usage via import of 'codes.reactive.scalatime._'" in {
    import codes.reactive.scalatime._

    val period: Period = Period.days(1)

    val duration = Duration.days(1)

    duration shouldBe DurationTestHelpers.days(1L)

    period shouldBe PeriodTestHelpers.days(1)
  }

  "'extended' usage with additional implicits imported of 'Scalatime._'" in {
    import codes.reactive.scalatime._
    import Scalatime._

    val duration: Duration = 1L day

    val otherDuration: Duration = 2L days

    val period = 1 day
    val otherPeriod = 2 days

    duration + otherDuration shouldBe DurationTestHelpers.days(3L)
    period + otherPeriod shouldBe PeriodTestHelpers.days(3)
  }

}
