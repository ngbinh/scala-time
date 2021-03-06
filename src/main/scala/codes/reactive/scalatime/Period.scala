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

package codes.reactive.scalatime

import impl.TimeSupport.{Period => JP}
import scala.util.Try


/** Factory object for obtaining instances of [[Period]].
  *
  * Period is a date-based amount of time in the ISO-8601 calendar system, such as '2 years, 3 months and 4 days'.
  *
  * @example
  *          {{{
  *            import codes.reactive.scalatime._
  *
  *            // Obtain a Period of 10 weeks
  *            val tenWeeks = Period.weeks(10)
  *
  *            // Obtain a Period of zero
  *            val zero = Period.Nil
  *          }}}
  * @define ObtP  Obtains a Period
  */
object Period {

  /** $ObtP from a temporal amount by looping around the set of units from the amount and using
    * the YEARS, MONTHS and DAYS units to create a period.
    * @throws DateTimeException if unable to convert to a Period.
    */
  def from(amount: TemporalAmount): Period = JP.from(amount)

  /** Obtains a Period consisting of the number of years, months, and days between two dates. */
  def between(start: LocalDate, end: LocalDate): Period = JP.between(start, end)

  /** $ObtP from text based on the ISO-8601 Period format - PnDTnHnMn.nS - PnYnMnD and PnW.
    *
    * ==== Text Format ====
    * The string starts with an optional sign, denoted by the ASCII negative or positive symbol. If negative, the whole
    * period is negated.
    *
    * The ASCII letter "P" is next in upper or lower case.
    *
    * There are then four sections, each consisting of a number and a suffix. At least one of the four sections must be
    * present. The sections have suffixes in ASCII of "Y", "M", "W" and "D" for years, months, weeks and days, accepted
    * in upper or lower case.
    *
    * The suffixes must occur in order. The number part of each section must consist of ASCII digits. The number may be
    * prefixed by the ASCII negative or positive symbol. The number must parse to an int.
    *
    * The leading plus/minus sign, and negative values for other units are not part of the ISO-8601 standard.
    *
    * @throws DateTimeParseException if the text cannot be parsed.
    *
    * @example
    * {{{
    *               import codes.reactive.scalatime._
    *
    *               // Parses as 1 year, 2 months, 3 days
    *               val peri1 = Period.parse("P1Y2M3D")
    *
    *               // Parses as minus 1 year, 2 months, zero days
    *               val peri2 = Period.parse("P-1Y2M")
    * }}}
    */
  def parse(text: String): Period = JP.parse(text)

  /** $ObtP representing a number of days. */
  def days(days: Int): Period = JP.ofDays(days)

  /** $ObtP representing a number of weeks. */
  def weeks(weeks: Int): Period = JP.ofWeeks(weeks)

  /** $ObtP representing a number of months. */
  def months(months: Int): Period = JP.ofMonths(months)

  /** $ObtP representing a number of years. */
  def years(years: Int): Period = JP.ofYears(years)

  /** $ObtP of zero. */
  def empty: Period = JP.zero
  final val EmptyPeriod = JP.zero
}
