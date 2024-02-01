# ToDoList_for_IoT_Classes-
## Project for IoT Classes - ToDo List based on CRUD
Description
The ToDo API allows managing tasks in the ToDo application through CRUD operations.

## Endpoints

### Getting all tasks
Get     /todo/list
                                              
Returns a view containing a list of all tasks.
![image](https://github.com/MarcinLar/ToDoList_for_IoT_Classes-/assets/127322724/f36f1095-4816-4f89-bbff-ba93876630de)

### Adding a new task
Get    /todo/new
                                              
Returns a form for adding a new task.
Redirects to todo/add or edit.
![image](https://github.com/MarcinLar/ToDoList_for_IoT_Classes-/assets/127322724/ecdea37b-e512-45e3-b96f-1a86947d66ce)

### Updating an existing task
Get    /todo/{id}/edit
                                              
Returns a form for editing a task.
Redirects to the /todo/add or edit endpoint with the parameter id of the task.
![image](https://github.com/MarcinLar/ToDoList_for_IoT_Classes-/assets/127322724/0b2d2354-644f-4dce-a7fa-09a33d919350)

### Post     /todo/ add or edit
                                              
Adds or edits a task based on the data entered in the form.
Required parameters:
Id: Automatically assigned
Title: task title (required)
Description: task description (optional)

### Getting task details
Get      /todo/{id}/show
                                              
Returns a view containing detailed information about the task with the specified identifier.
![image](https://github.com/MarcinLar/ToDoList_for_IoT_Classes-/assets/127322724/9ab63705-b914-4cf0-8f8c-84ac3fec47da)


### Deleting an existing task
Get      /todo/{id}/delete
                                              
Deletes the existing task with the specified identifier when we clik the delete button on /todo/list side.

### Response codes
200 OK - the request was successful.
302 Found - redirect to another resource.

### Authorization
The ToDo List API does not require authentication.

### Additional information
After adding, editing, or deleting a task, the user will be redirected to a page displaying the list of all tasks.
During task addition or editing, the title field is required.

### Usage examples

https://github.com/MarcinLar/ToDoList_for_IoT_Classes-/assets/127322724/6a4e3e3e-9f23-4222-992b-9c85e9208c01


