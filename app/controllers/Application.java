package controllers;

import java.util.List;

import models.Task;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
  public static Result index() {
	  List<Task> tasks = Task.find.all();
    return ok(index.render("Your new application is ready. Test1!!"));
  }
  
}