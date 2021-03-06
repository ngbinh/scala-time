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

import impl.TimeSupport.{ZonedDateTime => ZD}
import util.Try


/** Factory object for obtaining [[ZonedDateTime]] instances.  */
object ZonedDateTime {

  /** Obtains a [[ZonedDateTime]] by querying the current system clock at UTC for the current date. */
  def apply(): ZonedDateTime = ZD.now(Clock())

  /** Obtains a [[ZonedDateTime]] by querying the specified clock for the current time. */
  def apply(clock: Clock): ZonedDateTime = ZD.now(clock)

  /** Obtains a [[ZonedDateTime]] from the specified [[LocalDate]], [[LocalTime]], and [[ZoneId]]. */
  def apply(date: LocalDate, time: LocalTime, zone: ZoneId): ZonedDateTime = ZD.of(date, time, zone)

  /** Obtains a [[ZonedDateTime]] from the specified [[LocalDateTime]] and [[ZoneId]]. */
  def apply(dateTime: LocalDateTime, zone: ZoneId): ZonedDateTime = ZD.of(dateTime, zone)

  /** Queries a [[Temporal]] instance to obtain a [[ZonedDateTime]].
    * @throws DateTimeException if unable to convert to a ZonedDateTime.
    */
  def from(from: TemporalAccessor): ZonedDateTime = ZD.from(from)

  /** Obtains a [[ZonedDateTime]] from a year, month, day, hour, minute, second, nanosecond and zone. The values
    * of all fields must be within range, and the day must be valid for the year and month.
    * @throws DateTimeException if the value of any field is out of range, or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int,
         month: Int,
         day: Int,
         hour: Int,
         minute: Int,
         second: Int,
         nano: Int,
         zone: ZoneId): ZonedDateTime =
    ZD.of(year, month, day, hour, minute, second, nano, zone)

  /** Obtains a [[ZonedDateTime]] from a year, month, day, hour, minute, second, nanosecond and zone. The values
    * of all fields must be within range, and the day must be valid for the year and month.
    * @throws DateTimeException if the value of any field is out of range, or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int,
         month: Month,
         day: Int,
         hour: Int,
         minute: Int,
         second: Int,
         nano: Int,
         zone: ZoneId): ZonedDateTime =
    ZD.of(year, month.getValue, day, hour, minute, second, nano, zone)

  /** Obtains a [[ZonedDateTime]] from text formatted according to [[format.DateTimeFormatter.Iso.ZonedDateTime]].
    *
    * @param text the text to parse such as "2011-12-03T10:15:30+01:00[Europe/Paris]".
    * @throws DateTimeParseException if the text cannot be parsed.
    */
  def parse(text: String): ZonedDateTime = ZD.parse(text, format.DateTimeFormatter.Iso.ZonedDateTime)

  /** Obtains a [[ZonedDateTime]] from valid text formatted according to the provided `formatter`.
    * @throws DateTimeParseException if the text cannot be parsed.
    */
  def parse(text: String, formatter: DateTimeFormatter): ZonedDateTime = ZD.parse(text, formatter)

}
