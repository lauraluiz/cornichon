package com.github.agourlay.cornichon.util

import monix.eval.Task
import monix.execution.Scheduler

import scala.concurrent.Future

trait TaskSpec {
  implicit val scheduler: Scheduler = Scheduler.Implicits.global
  implicit def taskToFuture[A](t: Task[A]): Future[A] = t.runToFuture(scheduler)
}