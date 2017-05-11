package jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MonPhaseListener implements PhaseListener {
  @Override
  public void afterPhase(PhaseEvent event) {
    System.out.println("Après " + event.getPhaseId());
  }
  @Override
  public PhaseId getPhaseId() {
    // ou, par exemple, PhaseId.INVOKE_APPLICATION
    return PhaseId.ANY_PHASE;
  }
  @Override
  public void beforePhase(PhaseEvent event) {
    System.out.println("Avant " + event.getPhaseId());
  }

}
