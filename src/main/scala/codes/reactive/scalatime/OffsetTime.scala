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

import impl.TimeSupport.{OffsetTime => OT}
import util.Try


/** Factory object for obtaining [[OffsetTime]] instances. */
object OffsetTime {

  /** Obtains an [[OffsetTime]] by querying the current system clock at UTC for the current time. */
  def apply(): OffsetTime = OT.now(Clock())

  /** Obtains an [[OffsetTime]] by querying the specified clock for the current time. */
  def apply(clock: Clock): OffsetTime = OT.now(clock)

  /** Obtains an [[OffsetTime]] from a specified [[LocalTime]] and [[ZoneOffset]]. */
  def apply(localTime: LocalTime, offset: ZoneOffset): OffsetTime = OT.of(localTime, offset)

  /** Tries to query a [[Temporal]] instance to obtain an [[OffsetTime]]. */
  def from(from: TemporalAccessor): Try[OffsetTime] = Try(OT.from(from))

  /** Tries to obtain an [[OffsetTime]] instance from text formatted according to
    * [[format.DateTimeFormatter.Iso.OffsetTime]].
    *
    * @param text the text to parse such as "10:15:30"
    */
  def parse(text: String): Try[OffsetTime] = Try(OT.parse(text, format.DateTimeFormatter.Iso.OffsetTime))

  /** Tries to obtain an [[OffsetTime]] instance from valid text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[OffsetTime] = Try(OT.parse(text, formatter))

  /** Tries to obtain an [[OffsetTime]] instance from an hour, minute, second and nanosecond. All values must be within
    * range.
    */
  def of(hour: Int, minute: Int, second: Int, nano: Int, offset: ZoneOffset): Try[OffsetTime] =
    Try(OT.of(hour, minute, second, nano, offset))

  /** The maximum supported [[OffsetTime]] ('23:59:59.999999999-18:00' - the time just before midnight at the end of
    * the day in the minimum offset)
    */
  val Max: OffsetTime = OT.max

  /** The minimum supported [[OffsetTime]] ('00:00:00+18:00' - the time of midnight at the start of the day in the
    * maximum offset)
    */
  val Min: OffsetTime = OT.min
}
