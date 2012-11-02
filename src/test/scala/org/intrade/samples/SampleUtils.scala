package org.intrade.samples

import java.text.SimpleDateFormat
import java.util.Date

object SampleUtils {
  def joinWithCommas(items: Any*) = items.mkString(",")

  def printDate(timestamp: Long) =
    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date(timestamp).getTime)
}