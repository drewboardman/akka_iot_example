Intro
----------
* Using Akka instead of just creating actors solves a lot of boilerplate
  infrastucture stuff
  - includes the actor lifecycle and failure handling (let it crash)

Hierarchy
--------------
* using `context.actorOf()` or `system.actorOf()` guarantees that an actor
  always belongs to a parent
  - *parent actor* And *child actor*

