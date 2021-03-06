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

package codes.reactive.scalatime.impl

import codes.reactive.scalatime._

import scala.language.implicitConversions

/** Enriches a [[TemporalAdjuster]] with additional methods. */
final class TemporalAdjusterOps(val underlying: TemporalAdjuster) extends AnyVal {

  /** Adjusts the provided temporal object using the logic encapsulated in this.
    *
    * @throws DateTimeException if unable to make the adjustment.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def <<=[A <: Temporal](temporal: A): A = underlying.adjustInto(temporal).asInstanceOf[A]  //TODO: Finalise method name

}

trait ToTemporalAdjusterOps extends Any {

  implicit final def toTemporalAdjusterOpsFromTemporalAdjuster(f: TemporalAdjuster): TemporalAdjusterOps = new TemporalAdjusterOps(f)
}