package com.zac.page

import geb.Page

class YahooSearchResultPage extends Page {

  static url = ""

  static at = { title.contains("検索結果") }

  static content = {
  }
}