# ToDoList_for_IoT_Classes-
Student Project for IoT Classes - ToDo List based on CRUD
Description
The ToDo API allows managing tasks in the ToDo application through CRUD operations.

Endpoints

Getting all tasks
Get     /todo/list
Returns a view containing a list of all tasks.

Adding a new task
Get    /todo/new
Returns a form for adding a new task.
Redirects to todo/add or edit.

Updating an existing task
Get    /todo/{id}/edit
Returns a form for editing a task.
Redirects to the /todo/add or edit endpoint with the parameter id of the task.

Post     /todo/ add or edit
Adds or edits a task based on the data entered in the form.
Required parameters:
Id: Automatically assigned
Title: task title (required)
Description: task description (optional)

Getting task details
Get      /todo/{id}/show
Returns a view containing detailed information about the task with the specified identifier.

Deleting an existing task
Get      /todo/{id}/delete
Deletes the existing task with the specified identifier.

Response codes
200 OK - the request was successful.
302 Found - redirect to another resource.

Authorization
The ToDo List API does not require authentication.

Additional information
After adding, editing, or deleting a task, the user will be redirected to a page displaying the list of all tasks.
During task addition or editing, the title field is required.

Usage examples
