# Thunderbots 2015-2016 Competition Code

This is all of the code used by the Thunderbots Robotics Team in the 2015-2016 FTC game.

This entire repository is open source, and is made available under the GNU General Public License v. 3.0 (GPLv3) or later. A full copy of the license is available as [the LICENSE file in this repository](LICENSE), or at [the GNU license page](http://www.gnu.org/licenses/gpl.txt). A quick summary of the text is also available [here](https://tldrlegal.com/license/gnu-general-public-license-v3-%28gpl-3%29). 

The license does provide a header that is recommended to be put at the top of every file in the repository. Some files in the repository here contain the header, but other files here may not, and they are all fully protected under the GPLv3 license. The header is provided as follows, and applies generically to all files in this repository, including other branches:

> Copyright (C) 2015-2016 Thunderbots Robotics
> 
> This program is free software: you can redistribute it and/or modify
> it under the terms of the GNU General Public License as published by
> the Free Software Foundation, either version 3 of the License, or
> (at your option) any later version.
> 
> This program is distributed in the hope that it will be useful,
> but WITHOUT ANY WARRANTY; without even the implied warranty of
> MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
> GNU General Public License for more details.

###Dependencies

This code is dependent on the code found in the [LightningSDK](https://github.com/Thunderbots5604/LightningSDK) repository. This project or a .jar of the project must be on the build path in order for any code found in this repository to compile successfully. A JAR file of the SDK is available for download [here](https://github.com/Thunderbots5604/LightningSDK/releases).

This repository, the [LightningSDK](https://github.com/Thunderbots5604/LightningSDK), and the [Annotations](https://github.com/Thunderbots5604/Annotations) repository must all be compiled with JDK 1.6 in order to work with the Thunderbots Robot Controller.

An [ant](ant.apache.org) script to compile all three and create JARs for 2015-Code and LightningSDK is available [here](https://gist.githubusercontent.com/PranavMathur/447f1047ffe55a86111b/raw/1f97b22badc86216b85e3b093847dfe4f8d87c34/build.xml)
