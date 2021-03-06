package org.tmt.cli

import caseapp.HelpMessage
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
      cswArgs: List[String],
      @HelpMessage(
        "Arguments passed to Gateway Server application, " +
          "run `sbt tmt-backend/runMain esw.gateway.server.GatewayMain start -h` to see all the options"
      )
      gatewayArgs: List[String]
  ) extends BackendCommand
}
