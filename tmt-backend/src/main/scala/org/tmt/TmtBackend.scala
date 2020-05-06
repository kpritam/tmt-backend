package org.tmt

import esw.gateway.server.GatewayMain
import caseapp.core.app.CommandApp
import caseapp.core.RemainingArgs
import org.tmt.cli.BackendCommand
import csw.services.{Main => CswServices}
import csw.services.utils.ColoredConsole

object TmtBackend extends CommandApp[BackendCommand] {
  override def appName: String    = "tmt-backend"
  override def appVersion: String = "0.1.0"
  override def progName: String   = "tmt-backend"

  override def run(options: BackendCommand, remainingArgs: RemainingArgs): Unit =
    options match {
      case BackendCommand.Start(cswServicesArgs, gatewayArgs) =>
        startCswServices(cswServicesArgs)
        startGateway(gatewayArgs)
    }

  private def startCswServices(args: List[String]) = CswServices.main(("start" :: args).toArray)
  private def startGateway(args: List[String])     = {
    ColoredConsole.GREEN.println("Starting Gateway Server ...")
    val gatewayRoles = getClass.getResource("/gatewayRoles.conf").getPath
    GatewayMain.main(("start" :: args ::: List("--local", "-c", gatewayRoles)).toArray)
    ColoredConsole.GREEN.println("Successfully started Gateway Server.")
  }
}
