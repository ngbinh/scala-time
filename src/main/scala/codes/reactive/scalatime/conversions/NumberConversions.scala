/*******************************************************************
 * See the NOTICE file distributed with this work for additional   *
 * information regarding Copyright ownership.  The author/authors  *
 * license this file to you under the terms of the Apache License, *
 * Version 2.0 (the "License"); you may not use this file except   *
 * in compliance with the License.  You may obtain a copy of the   *
 * License at:                                                     *
 *                                                                 *
 *     http://www.apache.org/licenses/LICENSE-2.0                  *
 *                                                                 *
 * Unless required by applicable law or agreed to in writing,      *
 * software distributed under the License is distributed on an     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY          *
 * KIND, either express or implied.  See the License for the       *
 * specific language governing permissions and limitations         *
 * under the License.                                              *
 *******************************************************************/

package codes.reactive.scalatime
package conversions

import temporal.{IntPeriod, LongDuration}


trait NumberConversions {

  /** Creates a new [[codes.reactive.scalatime.temporal.IntPeriod]] from an [[scala.Int]]
    *
    * @param in the Int to be converted
    * @return a new [[codes.reactive.scalatime.temporal.IntPeriod]]
    */
  def intPeriod(in: Int): IntPeriod = new IntPeriod(in)

  /** Creates a new [[codes.reactive.scalatime.temporal.LongDuration]] from a [[scala.Long]]
    *
    * @param in the Long to be converted
    * @return a new [[codes.reactive.scalatime.temporal.LongDuration]]
    */
  def longDuration(in: Long): LongDuration = new LongDuration(in)
}

trait NumberImplicits extends NumberConversions {

  /** Implicit function to convert an Int to an [[codes.reactive.scalatime.temporal.IntPeriod]]
    * We use a val to avoid having to explicitly enable
    * implicit conversions.
    */
  implicit val augmentInt: Int => IntPeriod = intPeriod

  /** Implicit function to convert a Long to a [[codes.reactive.scalatime.temporal.LongDuration]]
    * We use a val to avoid having to explicitly enable
    * implicit conversions.
    */
  implicit val augmentLong: Long => LongDuration = longDuration
}
