# Item Pickup Customization
[![CurseForge](http://cf.way2muchnoise.eu/full_317756_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/item-pickup-customization)
[![Curseforge](http://cf.way2muchnoise.eu/versions/For%20MC_317756_all.svg)](https://www.curseforge.com/minecraft/mc-mods/item-pickup-customization)
[![](https://jitpack.io/v/Draylar/vanilla-hammers.svg)](https://jitpack.io/#Draylar/item-pickup-customization)

Item Pickup Customization (IPC) is a Fabric mod inspired by [ItemPhysic](https://www.curseforge.com/minecraft/mc-mods/itemphysic). It provides options to customize Item Entities and their behaviors related to picking up. The current options are:
- toggle player item pickup on collision
- toggle player item pickup on click

By default, both options are turned on. You can customize them by opening the config file at `run/config/item-pickup-customization.json`:
```json
{
  "allowItemPickup": false,
  "allowClickPickup": true
}
```

Item Pickup Customization is required on the client **and** server. I would recommend using it on the client in combination with [Better Dropped Items](https://github.com/Draylar/better-dropped-items) for the best experince!

### Visualization (click images for video)
**allowItemPickup**: false

<a href="https://streamable.com/cn726h"><img src="https://i.imgur.com/gGxFs0S.png" width="400"></a>

**allowClickPickup**: true

<a href="https://streamable.com/jpazkh"><img src="https://i.imgur.com/MUGHqB1.png" width="400"></a>

### Versioning
| Version  | Has Release |
| ------------- | ------------- |
| 1.14  |    ❌ |
| 1.15  |    ✔️ |
| 1.16  |    ❌ |

### License
IPC is licensed under MIT. You're free to use the code in this repo as you wish.
