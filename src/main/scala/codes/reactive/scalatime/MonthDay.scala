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

import impl.TimeSupport

import util.Try


/** Factory for obtaining instances of [[MonthDay]]. */
object MonthDay {

  /** Obtains the current [[MonthDay]] at UTC. */
  def apply(): MonthDay = TimeSupport.MonthDay.now(ZoneId.UTC)

  /** Obtains a [[MonthDay]] by querying the specified clock for the current month and day. */
  def apply(clock: Clock): MonthDay = TimeSupport.MonthDay.now(clock)

  /** Obtains the current [[MonthDay]] at the specified zone. */
  def apply(zone: ZoneId): MonthDay = TimeSupport.MonthDay.now(zone)

  /** Tries to query a [[Temporal]] to obtain a [[MonthDay]]. */
  def from(temporal: TemporalAccessor): Try[MonthDay] = Try(TimeSupport.MonthDay.from(temporal))

  /** Tries to obtain a [[MonthDay]] from the specified month and day. */
  def of(month: Month, day: Int): Try[MonthDay] = Try(TimeSupport.MonthDay.of(month, day))

  /** Tries to obtain a [[MonthDay]] from the specified month and day. */
  def of(month: Int, day: Int): Try[MonthDay] = Try(TimeSupport.MonthDay.of(Month(month), day))

  /** Tries to obtain a [[MonthDay]] from text formatted as `--MM-dd`, such as `2014-10`. */
  def parse(text: String): Try[MonthDay] = Try(TimeSupport.MonthDay.parse(text))

  /** Tries to obtain a [[MonthDay]] from text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[MonthDay] =
    Try(TimeSupport.MonthDay.parse(text, formatter))

}
