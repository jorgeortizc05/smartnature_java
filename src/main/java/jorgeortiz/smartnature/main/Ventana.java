package jorgeortiz.smartnature.main;

import net.sourceforge.jFuzzyLogic.FIS;

public class Ventana extends javax.swing.JFrame{

	private javax.swing.JSlider sldHumedad;
	private javax.swing.JSlider sldTempAmb;
	private javax.swing.JSlider sldHumAmb;
	private net.sourceforge.jFuzzyLogic.FIS FIS;
	private net.sourceforge.jFuzzyLogic.plot.JDialogFis jDialogFis;
	private net.sourceforge.jFuzzyLogic.FunctionBlock functionBlock;

	public Ventana(){
		super("JFuzzy Logic");
		
		sldHumedad=new javax.swing.JSlider();
		sldHumedad.setMinimum(0);
		sldHumedad.setMaximum(1023);
		sldHumedad.setMajorTickSpacing(10);
		sldHumedad.setMinorTickSpacing(1);
		sldHumedad.setPaintTicks(true);
		sldHumedad.setPaintLabels(true);
		
		sldTempAmb=new javax.swing.JSlider();
		sldTempAmb.setMinimum(0);
		sldTempAmb.setMaximum(45);
		sldTempAmb.setMajorTickSpacing(10);
		sldTempAmb.setMinorTickSpacing(1);
		sldTempAmb.setPaintTicks(true);
		sldTempAmb.setPaintLabels(true);
		
		sldHumAmb=new javax.swing.JSlider();
		sldHumAmb.setMinimum(0);
		sldHumAmb.setMaximum(100);
		sldHumAmb.setMajorTickSpacing(10);
		sldHumAmb.setMinorTickSpacing(1);
		sldHumAmb.setPaintTicks(true);
		sldHumAmb.setPaintLabels(true);
		
		sldHumedad.addChangeListener(new javax.swing.event.ChangeListener(){
			public void stateChanged(javax.swing.event.ChangeEvent c){
				FIS.setVariable("humedadSuelo",new Double(sldHumedad.getValue()).doubleValue());
				FIS.evaluate();
				jDialogFis.repaint();
				
			}
		});
		
		sldHumedad.addChangeListener(new javax.swing.event.ChangeListener(){
			public void stateChanged(javax.swing.event.ChangeEvent c){
				FIS.setVariable("temperaturaAmbiente",new Double(sldTempAmb.getValue()).doubleValue());
				FIS.evaluate();
				jDialogFis.repaint();
				
			}
		});
		
		sldHumedad.addChangeListener(new javax.swing.event.ChangeListener(){
			public void stateChanged(javax.swing.event.ChangeEvent c){
				FIS.setVariable("humedadAmbiente",new Double(sldHumAmb.getValue()).doubleValue());
				FIS.evaluate();
				jDialogFis.repaint();
				
			}
		});
		
// 		setLayout(new java.awt.FlowLayout());
		add(sldHumedad);
		add(sldTempAmb);
		add(sldHumAmb);

		setSize(700,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cargarFCL();
	}
	
	private void cargarFCL(){
		FIS=net.sourceforge.jFuzzyLogic.FIS.load("ControlDifuso.fcl",true);
		jDialogFis=new net.sourceforge.jFuzzyLogic.plot.JDialogFis(FIS);
		sldHumedad.setValue(2);
		sldTempAmb.setValue(35);
		sldHumAmb.setValue(29);
		System.out.println(sldHumedad.getValue());
		FIS.setVariable("humedadSuelo",new Double(sldHumedad.getValue()));
		FIS.setVariable("temperaturaAmbiente",new Double(sldTempAmb.getValue()));
		FIS.setVariable("humedadAmbiente",new Double(sldHumAmb.getValue()));
		FIS.evaluate();
		net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(FIS);
		functionBlock=FIS.getFunctionBlock(null);
		double v=functionBlock.getVariable("riego").getLatestDefuzzifiedValue();
		System.out.println("Valor: "+v);
		
		net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(functionBlock.getVariable("riego"), functionBlock.getVariable("riego").getDefuzzifier(), true);
	}
	
	public static void main(String [] args){
		new Ventana().setVisible(true);
	}
}