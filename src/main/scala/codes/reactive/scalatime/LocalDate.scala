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

import impl.TimeSupport.{LocalDate => LD}
import scala.util.Try


/** Factory object for creation of [[LocalDate]] instances. */
object LocalDate {

  /** Obtains a [[LocalDate]] by querying the current system clock at UTC for the current date. */
  def apply(): LocalDate = LD.now(Clock())

  /** Obtains a [[LocalDate]] by querying the specified clock for the current date. */
  def apply(clock: Clock): LocalDate = LD.now(clock)

  /** Tries to query a [[Temporal]] instance to obtain a [[LocalDate]]. */
  def from(from: TemporalAccessor): Try[LocalDate] = Try(LD.from(from))

  /** Tries to obtain a [[LocalDate]] from a year, month and day. The values of all fields must be within range, and
    * the day must be valid for the year and month.
    */
  def of(year: Int, month: Int, day: Int): Try[LocalDate] = Try(LD.of(year, Month(month), day))

  /** Tries to obtain a [[LocalDate]] from a year, [[Month]] and day. The values of all fields must be within range,
    * and the day must be valid for the year and month.
    */
  def of(year: Int, month: Month, day: Int): Try[LocalDate] = Try(LD.of(year, month, day))

  /** Tries to obtain a [[LocalDate]] from text formatted according to [[format.DateTimeFormatter.Iso.LocalDate]]. */
  def parse(text: String): Try[LocalDate] = Try(LD.parse(text, format.DateTimeFormatter.Iso.LocalDate))

  /** Tries to obtain a [[LocalDate]] text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[LocalDate] = Try(LD.parse(text, formatter))

}
