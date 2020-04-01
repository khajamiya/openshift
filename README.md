# ----OpenShift Training----

### Steps to build docker image and push it to docker hub

##### If you have old installation and you want to clean everything
```
docker system prune -a
```

##### List all Containers
```
docker ps 
```

##### check all existing images
```
docker image ls
```

##### Build Docker Image on local machine
```
docker build -t spring-boot:1.0 .
```

##### Running on local system
```
docker run -d -p 8080:8080 -t spring-boot:1.0
```

##### Stop a docker container by container id
```
docker stop <Container Id>
```

##### Tag first before push to docker hub.
```
docker image tag spring-boot:1.0 <your_id>/spring-boot:1.0
docker image push <your_id>/spring-boot:1.0
```

##### In production server.
```bash
$ docker pull <your_id>/spring-boot:1.0
$ docker run -d -p 80:8080 -t spring-boot:1.0
```


#---- OpenShift Command Cheat Sheet ----
Login to OpenShift
```
oc login https://api.pro-eu-west-1.openshift.com --token=<user-login-token>
```
Get Token of logged in account
```
oc whoami -t
```
Logout from openshift
```
oc logout
```
List help topics
```
oc help
```
Get help on any command
```
oc <command> --help
```
###--- Resource Inspection Utility Commands ---
Display all resources available with in depth information
```
oc describe all
```
List everything on OpenShift cluster
```
oc get all
``` 
Examine the cluster quota defined for the environment:
```
oc describe AppliedClusterResourceQuota
```

###--- Commands Related to Project ---
Overview of current project
```
oc status
```

Display all projects
```
oc get projects
```
Display currently using project
```
oc project
```
Use an existing project or switching project
```
oc project <project name>
```
Creating a new project
```
oc new-project <project-name> --description=”Your Description” –display-name=”<name to be displayed on openshift UI>”
```
###--- Commands Related to Pods ---

Checking status for pod. This will display information about the pod lifecycle
```
oc describe pod
```

List all the pods
```
oc get pods
```
List all pods and show more details about them.
```
oc get -o wide pods
```
List pod names
```
oc get pod -o name
```
Get pod logs
```
oc logs <pod-name> --timestamp
```
SSH into pod
```
oc rsh <pod-name>
```
Executing a single command on a pod
```
oc exec <pod-name> <command-to-be-executed>
```

### --- Commands for build ---
Start a build and follow the logs on screen
```
oc start-build <your-build-config-name> --follow
```
Create a build from a Docker file and deploy
```
cat Dockerfile | oc new-build --dockerfile=- --to=<your-app-name>
```
Create build from local dir with Dockerfile and deploy
```
oc new-build --startegy=docker --binary=true --name=<your-app-name>
oc start-build <your-app-name-from-last-command> --from-dir=.
```



Getting all endpoints from OpenShift cluster
```
oc get endpoints --namespace=<project name>
```


Note:This might fail as we do not have rights to create new project

###--- Delete resources --
#####Delete all the resources from a project
```
oc delete all --all --namespace=demoproject
```


###--- Monitoring Logs ---
#####Watching event log on project
```
oc logs -p
```
#####Show all OpenShift events occurring on current project and keep watching it(-w got watch). These events include scheduling events, pod startup etc
```
oc get events -w
```
#####Getting Logs of different resources
```
oc –loglevel 7 get pod
```

###--- Miscellaneous ---
Creating a Custom template by exporting existing resources
```
oc export is,bc,dc,svc,route --as-template > mytemplate.yml
```
