# Event-based orc animation!

This is an extension of the MVC project where we integrated an event-queue action/subscriber model. This allows us to create an interactive experience.

The very first thing we did was make the program run on an event-based timer. The timer is set to trigger an action every DRAW_DELAY ms. That action is defined as a model update and a view update. 

Next, we added a button that toggles the movement of the orc. At first we were confused with how to pass the model-altering button into the view, but we accomplished this by creating the button in the controller, assigning it an ActionListener there, and then handing the button off to the View via the View's controller.

Next, we needed to handle key-board input to change the direction of the orc. We accomplished this by adding a keyListener to the view and handing it a subclass of a KeyAdapter. In our case, the Model class extends the KeyAdapter so as to update itself. In future, we would probably separate the KeyAdapter implementation from the Model so that the Model isn't mucked up with changing its own state.

### Some notes (from Riley)

I worked on tying all of the code together to improve performance and better adapt the event/listener model. One of the biggest issues (in general) was handling the view update code. For a while there were a lot of visual quirks; the button would be obscured when the orc image moved over it, the orc would leave a trail of duplicated images. I realized that doing all of the orc and button functions at the top level of the JPanel update method increased the complexity and it was easy to move one line of code that would break everything.

In the future I'd like to have the View, at the top level, be a very simple JFrame that draws discrete components to the panel. This way the logic for drawing the orc can be abstracted away from the logic to draw the button. I'm suggesting that each component have its own class. So we could make a View that draws OrcView and ButtonView components onto its own frame. This is similar to how component-based web development works. The issue then is to keep track of the state (or model) in a consistent way. How does the ButtonView communicate with the OrcView?

For one, the way we interact with the model needs to be more structured and rigid. The model should work only as a way to store the current state of the application. It should have simple getters and setters that merely facilitate the flow of data into and out of the model. The controller should then handle the more complicated logic in transisitioning model states. The view is merely a reflection of the model's state. In this way, all event handlers would be managed and provisioned by the Controller. I think an opinionated super-set framework on top of Swing that FORCES the MVC event-based structure would be beneficial. Alas, this is outside the scope of Lab7 but worth keeping in mind for future java-based game development.