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

import chrono.{RichChronoLocalDate, RichChronoLocalDateTime, RichChronoZonedDateTime}


trait ChronoConverters {

  def richChronoLocalDate(underlying: ChronoLocalDate): RichChronoLocalDate = new RichChronoLocalDate(underlying)

  def richChronoLocalDateTime[A <: ChronoLocalDate](underlying: ChronoLocalDateTime[A]) = new RichChronoLocalDateTime(underlying)

  def richChronoZonedDateTime[A <: ChronoLocalDate](underlying: ChronoZonedDateTime[A]) = new RichChronoZonedDateTime(underlying)
}

// See Scala version specific source folder for ChronoImplicits
