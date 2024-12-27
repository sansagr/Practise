## Design an elevator system

- There are multiple elevators in the building
- There are multiple floors
- Each floor the lift interface can have two options (go up and go down)
- lift has an interface for you to take to a floor
- multiple floors can request a lift
- a lift can make stops at multiple floors
- life has a movement direction (going up and going down, idle)

3 cases

- idle (on a floor)
- Going up
- Going down

while idle or going up or going down

- the lift can get a request 
  - go down
  - go up

Whats are the Models

- Floor
- Lift
- Building

Controllers

- Each floor has lift fetch controller
- Each Lift has selectFloor controller

Services

- fetch life
- move To floor
