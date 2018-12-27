package cn.chenhuanming.study.scala.crawler

import org.apache.commons.lang.StringEscapeUtils
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

/**
  *
  * @author chenhuanming
  *         Created at 2018/6/7
  */
object Main {
  def main(args: Array[String]): Unit = {
    val url = "http://www.mafengwo.cn/rest/hotel/hotels/?data_style=recommendation&page%5Bmode%5D=random_next&page%5Bno%5D=1&page%5Bnum%5D=10&filter%5Bpoi_id%5D=5787218&filter%5Blat%5D=7.8860824931759&filter%5Blng%5D=98.293953537941&filter%5Bdistance%5D=2000&filter%5Bmddid%5D=11047&filter%5Bcheck_in%5D=2018-07-17&filter%5Bcheck_out%5D=2018-07-18&filter%5Bhas_booking_rooms%5D=1&filter%5Bsort_type%5D=comment&filter%5Bsort_flag%5D=DESC&filter%5Bcustom_img_1%5D=w240_h240"
    val data = Jsoup.connect(url)
      .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
      .header("Content-Type", "application/json;charset=UTF-8")
      .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
      .ignoreContentType(true)
        .execute().body()


    println(StringEscapeUtils.unescapeJava(data))


  }
}
