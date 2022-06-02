package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class IsAliveController @Inject() (cc: ControllerComponents)
    extends AbstractController(cc) {

  def isAlive: Action[AnyContent] = Action {
    Ok("I'm alive")
  }
}
