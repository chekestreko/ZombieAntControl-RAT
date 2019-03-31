package ZAC.MainClasses;

import ZAC.Controllers.ServerControl_Target;
import ZAC.Controllers.ServerControl_Terminal;

public class MainController {

    ServerControl_Terminal serverControl_terminal;
    ServerControl_Target serverControl_target;

    public void setServerControl_terminal(ServerControl_Terminal object) {

        serverControl_terminal = object;
    }

    public void setServerControl_target(ServerControl_Target object) {

        serverControl_target = object;
    }

    public void initializa(){

        serverControl_target.ItemSelection();
    }
}

