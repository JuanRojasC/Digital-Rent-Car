# Digital Rent Car
To receive the title of Certified Tech Developer, our final degree project was to create a website that would allow us to rent a vehicle. With a group of 4 people and implementing agile methodologies, we built a website that met the requirements, in addition to giving it different additional features that add value to the site.

<h2>Back-end</h2>
We decided to implement a backend based on microservices in order to gain experience in this form of back, and it was a complete success, we managed to deploy all the necessary services so that the client could carry out its claims, all this with tools such as spring boot, eureka services, OpenFeign, cloud-server, cloud-gateway, resilience4j, lombok and log4j, with these, we were able to manage more than 10 business classes, which together shaped our system.

<h2>Infrastructure</h2>
How to deploy our services? A question we answered using tools such as docker, docker-compose, docker-hub, terraform and aws. Each microservice in our backend was used to build a docker container and integrated into the docker-compose, so only one command was enough to start our entire backend on any computer that had docker. All this was deployed in AWS EC2 instances, and together with RDS they formed our entire infrastructure, with continuous iterations and improvements, it became necessary to accelerate our deployment, so we implemented Terraform to streamline this process.

<h2>Front-end</h2>
Fast, simple and scalable, the result, React. With the use of specific components for each area of our front end, custom hooks, providers and react-router-dom we were able to lay the foundations of our website, integrating our front end with our back end, we obtained a fully functional page. In the process of building this, tools such as Figma were indispensable for design, always keeping in mind the principles of UX for our UI. Our website was built thinking of being simple to use, visually pleasant and functional, for that we built the desktop and mobile style, which allows a friendly navigation in any environment.

<h2>Testing</h2>
Testing our components in a unitary and integration way was a very important task for the project, that is why with the use of tools such as Postman, JEST and manual testing, we managed to ensure the correct functioning of each built area of the project, and thus proceed to your deployment.

