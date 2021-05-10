import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private Employee scheduledEmployee;
    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseClicked(e-> {
        	System.out.println("This pane's date is: " + date);
				if(this.scheduledEmployee==null) {
					try {
						this.scheduledEmployee = new Employee();
						this.scheduledEmployee.startTimeSetter();
						this.scheduledEmployee.endTimeSetter();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else {
					System.out.println("\nAn employee is already scheduled for this day:"
							+ "\n");
					this.scheduledEmployee.getInfo();
					System.out.print("Would you like to switch employees?"
							+ "\n1 - YES"
							+ "\n2 - NO\n");
					try {
						this.scheduledEmployee.employeeSwitcher();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}}
				);
			
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
