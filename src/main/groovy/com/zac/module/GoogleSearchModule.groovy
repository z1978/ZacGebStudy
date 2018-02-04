package com.zac.module

import java.util.Spliterator
import java.util.function.Consumer

import com.zac.page.GoogleResultsPage

import geb.Module
import geb.navigator.Navigator

class GoogleSearchModule extends Module {

  def buttonName

  static content = {
    field { $("input", name: "q") }
    button(to: GoogleResultsPage) {
      $("button", name: buttonName)
    }
  }

@Override
public void forEach(Consumer<? super Navigator> action) {
	// TODO Auto-generated method stub
	
}
@Override
public Spliterator<Navigator> spliterator() {
	// TODO Auto-generated method stub
	return null;
}}