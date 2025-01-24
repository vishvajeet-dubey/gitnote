# How to install docker 🛥 on window machine

#### STEP 1 : Install WSL 🐧 in on window
- First install the WSL 2 {Windows Subsystem for Linux} following below link or command.
	- https://learn.microsoft.com/en-us/windows/wsl/install
- Open CMD and run `wsl --install`
- Once install then check the version using below command
- `wsl --status`

#### STEP 2: Install Docker 🛥
- Official link for Docker Desktop for Windows
	- https://docs.docker.com/desktop/setup/install/windows-install/
- Download the exe file and using on screen instruction install it.
- Restart the machine and open the Docker Desktop
- Create or sign up to the Docker hub
- Open the CMD and runt the below command to test docker is running or not

```cmd
docker images

------------------------------------------------------
C:\Users\vdube>docker images
REPOSITORY   TAG       IMAGE ID   CREATED   SIZE
------------------------------------------------------
```

