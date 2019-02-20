/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Utilities;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class LineSensor {
    private DigitalInput m_DI;
    private Boolean m_onState;
    private int m_numOnPulses;
    private int m_currentPulses;

    public LineSensor(int port, boolean onState, int NumOnPulses)
    {
        m_DI = new DigitalInput(port);
        m_onState = onState;
        m_numOnPulses = NumOnPulses;
        m_currentPulses = 0;
    }
       
    public void UpdateSensors()
    {
      boolean currentState = m_DI.get();
      if (currentState==m_onState)
        m_currentPulses += 1;
      else 
        m_currentPulses = 0;
    } 
    
    public boolean Get()
    {
        if (m_currentPulses>=m_numOnPulses)
            return true;
        else
            return false;
    
    }
    

}
