package org.tmt.cli

import caseapp.{HelpMessage, ExtraName => Short}
import caseapp.CommandName

sealed trait BackendCommand

object BackendCommand {
  @CommandName("start")
  @HelpMessage("Starts all the csw services and Gateway server")
  case class Start(
      @HelpMessage(
        "Arguments passed to CswServices application, " +
          "run `sbt tmt-backend/runMain csw.services.Main start -h` to see all the options"
      )
      @Short("c")
      cswServicesArgs: List[String],
      @HelpMessage(
        "Arguments passed to Gateway Server application, " +
          "run `sbt tmt-backend/runMain esw.gateway.server.GatewayMain start -h` to see all the options"
      )
      @Short("c")
      gatewayArgs: List[String]
  ) extends BackendCommand
}
