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

import impl.TimeSupport.{ZoneOffset => ZO}

import util.Try


/** Factory object for obtaining instances of [[ZoneOffset]]. Also provides default instances [[ZoneOffset.UTC]], and
  * [[ZoneOffset.EAT]] which correspond to time zone ids representing Coordinated Universal Time, and East African Time
  * respectively.
  *
  * @example
  *          {{{
  *            import codes.reactive.scalatime._
  *
  *            // Obtain the UTC zone
  *            val utcZone = ZoneOffset.UTC
  *
  *            // Obtain the current system zone
  *            val systemZone = ZoneOffset.system
  *
  *            // Obtain a time zone from the time offset of +5:00
  *            val plusFive = ZoneOffset(5)
  *          }}}
  */
object ZoneOffset {

  /** Obtains a [[ZoneOffset]] from an offset of hours - from 0 to ±18.
    * @throws DateTimeException if the offset is not in the required range.
    */
  def apply(hours: Int): ZoneOffset = ZO.h(hours)

  /** Obtains a [[ZoneOffset]] from an offset of hours (from 0 to ±18) and minutes (0 to ±59).
    * @throws DateTimeException if the offset is not in the required range.
    */
  def apply(hours: Int, minutes: Int): ZoneOffset = ZO.hm(hours, minutes)

  /** Obtainss a [[ZoneOffset]] from an offset of hours (from 0 to ±18), minutes and seconds (both 0 to ±59).
    * @throws DateTimeException if the offset is not in the required range.
    */
  def apply(hours: Int, minutes: Int, seconds: Int): ZoneOffset = ZO.hms(hours, minutes, seconds)

  /** Obtains a [[ZoneOffset]] from text.
    * See [[http://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html#of-java.lang.String- Java API.]] for more
    * detail.
    *
    * @throws DateTimeException if the offset ID is invalid.
    */
  def apply(offsetId: String): ZoneOffset = ZO.of(offsetId)

  /** Queries a [[Temporal]] instance to obtain its [[ZoneOffset]].
    * @throws DateTimeException if unable to convert to a ZoneOffset.
    */
  def from(temporal: TemporalAccessor): ZoneOffset = ZO.from(temporal)

  /** The time-zone offset representing EAT (Eastern Africa Time), with an offset of '+03:00'. */
  val EAT: ZoneOffset = apply(3)

  /** The time-zone offset representing UTC (Coordinated Universal Time), with an offset of '0'. */
  val UTC: ZoneOffset = ZO.utc

  /** The time-zone offset representing the minimum supported offset. */
  val MIN: ZoneOffset = ZO.min

  /** The time-zone offset representing the maximum supported offset. */
  val MAX: ZoneOffset = ZO.max

}
