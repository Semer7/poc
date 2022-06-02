package controllers

import play.api.mvc.{
  AbstractController,
  Action,
  AnyContent,
  ControllerComponents
}

import javax.inject.Inject

class SpawnController @Inject() (cc: ControllerComponents)
    extends AbstractController(cc) {

  def spawn: Action[AnyContent] = Action {
    Ok("TO DO")
  }
}
