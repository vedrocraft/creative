package ru.sema1ary.creative.command;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.async.Async;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import ru.sema1ary.vedrocraftapi.player.PlayerUtil;
import ru.sema1ary.vedrocraftapi.service.ConfigService;

@RequiredArgsConstructor
@Command(name = "speed")
public class SpeedCommand {
    private final ConfigService configService;

    @Async
    @Execute
    void execute(@Context Player sender, @Arg("скорость") int speed) {
        if(!isSpeedValid(sender, speed)) {
            return;
        }

        if(sender.isFlying()) {
            sender.setFlySpeed((float) speed / 10);
        } else {
            sender.setWalkSpeed((float) speed / 10);
        }

        PlayerUtil.sendMessage(sender, (String) configService.get("speed-change-message"));
    }

    @Async
    @Execute(name = "fly")
    void changeFlySpeed(@Context Player sender, @Arg("скорость") int speed) {
        if(!isSpeedValid(sender, speed)) {
            return;
        }

        sender.setFlySpeed((float) speed / 10);
        PlayerUtil.sendMessage(sender, (String) configService.get("speed-change-message"));
    }

    @Async
    @Execute(name = "walk")
    void changeWalkSpeed(@Context Player sender, @Arg("скорость") int speed) {
        if(!isSpeedValid(sender, speed)) {
            return;
        }

        sender.setWalkSpeed((float) speed / 10);
        PlayerUtil.sendMessage(sender, (String) configService.get("speed-change-message"));
    }

    @SuppressWarnings("all")
    private boolean isSpeedValid(Player sender, int speed) {

        if(speed < 1 || speed > 10) {
            PlayerUtil.sendMessage(sender, (String) configService.get("illegal-speed-message"));
            return false;
        }

        return true;
    }
}
