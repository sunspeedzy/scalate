/**
 * Copyright (C) 2009-2011 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.scalate.support

/**
 * Implements the Groovy style Elvis operator in Scala
 *
 * @version $Revision: 1.1 $
 */
class Elvis(val defaultValue: Any) {
  def ?:(value: Any) = if (value != null) value else defaultValue
}

/**
 * A helper class useful for implicit conversions when legacy code iterates over a Map without explicitly
 * decomposing the iterator value to a tuple
 */
case class MapEntry[A, B](key: A, value: B) {
  def getKey = key
  def getValue = value
}