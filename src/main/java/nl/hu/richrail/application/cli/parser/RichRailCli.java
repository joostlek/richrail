package nl.hu.richrail.application.cli.parser;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;
import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.services.TrainService;
import parser.RichRailBaseListener;

public class RichRailCli extends RichRailBaseListener {

    private final TrainService trainService;

    private final RichRailCliCallback callback;

    public RichRailCli(TrainService trainService, RichRailCliCallback callback) {
        this.trainService = trainService;
        this.callback = callback;
    }

    @Override
    public void enterCommandNewTrain(parser.RichRailParser.CommandNewTrainContext ctx) {
        try {
            this.trainService.createTrain(ctx.ID().getText());
            this.callback.writeMessage(String.format("De trein %s is aangemaakt.", ctx.ID().getText()));
        } catch (TrainServiceException e) {
            this.callback.writeMessage(e.getErrorMessage());
        }
    }

    @Override
    public void enterCommandNewLocomotive(parser.RichRailParser.CommandNewLocomotiveContext ctx) {
        try {
            this.trainService.createComponent(null, ctx.ID().getText(), RollingComponentType.LOCOMOTIVE, 0);
            this.callback.writeMessage(String.format("De locomotief %s is aangemaakt.", ctx.ID().getText()));
        } catch (TrainServiceException e) {
            this.callback.writeMessage(e.getErrorMessage());
        }
    }

    @Override
    public void enterCommandNewWagon(parser.RichRailParser.CommandNewWagonContext ctx) {
        try {
            int numSeats = 20;

            if (ctx.NUMBER() != null) {
                numSeats = Integer.valueOf(ctx.NUMBER().getText());
            }

            this.trainService.createComponent(null, ctx.ID().getText(), RollingComponentType.WAGON, numSeats);
            this.callback.writeMessage(String.format("De wagon %s is aangemaakt met %d stoelen.", ctx.ID().getText(), numSeats));
        } catch (TrainServiceException e) {
            this.callback.writeMessage(e.getErrorMessage());
        }
    }

    @Override
    public void enterCommandAdd(parser.RichRailParser.CommandAddContext ctx) {
        try {
            String componentKey = ctx.ID(0).getText();
            String trainKey = ctx.ID(1).getText();

            this.trainService.addComponentToTrain(trainKey, componentKey);
            this.callback.writeMessage(String.format("De wagon %s is gekoppeld aan de trein %s.", componentKey, trainKey));
        } catch (TrainServiceException e) {
            this.callback.writeMessage(e.getErrorMessage());
        }
    }

    @Override
    public void enterCommandGet(parser.RichRailParser.CommandGetContext ctx) {
        try {
            String paramType = ctx.type().getText();
            String paramKey = ctx.ID().getText();
            int result;

            switch (paramType) {
                case "train":
                    result = this.trainService.getTrainSeatCount(paramKey);
                    break;
                case "wagon":
                    result = this.trainService.getComponentSeatCount(paramKey);
                    break;
                default:
                    this.callback.writeMessage(String.format("Ongeldige type: '%s'.", paramType));
                    return;
            }

            this.callback.writeMessage(String.format("Aantal stoelen in %s %s: %d", paramType, paramKey, result));
        } catch (TrainServiceException e) {
            this.callback.writeMessage(e.getErrorMessage());
        }
    }

    @Override
    public void enterCommandDel(parser.RichRailParser.CommandDelContext ctx) {
        String paramType = ctx.type().getText();
        String paramKey = ctx.ID().getText();
        boolean result;

        switch (paramType) {
            case "train":
                result = trainService.removeTrain(paramKey);
                break;
            case "wagon":
                result = trainService.removeComponent(paramKey);
                break;
            default:
                this.callback.writeMessage(String.format("Ongeldige type: '%s'.", paramType));
                return;
        }

        this.callback.writeMessage(String.format(result
                ? "De %s %s is verwijderd."
                : "De %s %s bestaat niet.", paramType, paramKey));
    }

    @Override
    public void enterCommandRem(parser.RichRailParser.CommandRemContext ctx) {
        try {
            String componentKey = ctx.ID(0).getText();
            String trainKey = ctx.ID(1).getText();

            if (this.trainService.removeComponentFromTrain(trainKey, componentKey)) {
                this.callback.writeMessage(String.format("De wagon %s is verwijderd van de trein %s.", componentKey, trainKey));
            } else {
                this.callback.writeMessage(String.format("De wagon %s behoort niet tot de trein %s.", componentKey, trainKey));
            }
        } catch (TrainServiceException e) {
            this.callback.writeMessage(e.getErrorMessage());
        }
    }

}
