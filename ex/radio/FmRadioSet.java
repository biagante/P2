

public class FmRadioSet 
{

    private int volume = 7; // starts with default volume level 7
    private RadioStationInfo currentStation = null;

    static private RadioStationInfo[] listOfKnownStations = new RadioStationInfo[0];

    /**
     * tunes the radio using the intended station name
     */
    public void tune(String name) {
	boolean found = false;
	int i = 0;
	while (!found && i < listOfKnownStations.length) 
	{
	    found = listOfKnownStations[i].name().equalsIgnoreCase(name);
	    i++;
	}
	if (found)
	    currentStation = listOfKnownStations[i - 1];
    }

    /**
     * tunes the radio using the intended station frequency
     */
    public void tune(double frequency) 
    {
	boolean found = false;
	int i = 0;
	while (!found && i < listOfKnownStations.length) 
	{
	    found = listOfKnownStations[i].frequency() == frequency;
	    i++;
	}
	if (found)
	    currentStation = listOfKnownStations[i - 1];
    }

    public static void addStationInfo (RadioStationInfo station) 
    {
	RadioStationInfo[] newList = new RadioStationInfo[listOfKnownStations.length + 1];
	System.arraycopy(listOfKnownStations, 0, newList, 0,
		listOfKnownStations.length);
	newList[listOfKnownStations.length] = station;
	listOfKnownStations = newList;
    }

    public void turnDownVolume() 
    {
	volume--;
    }

    public void turnUpVolume() 
    {
	volume++;
    }

    public String currentPlayingStation() 
    {
	if (currentStation == null) {
	    return null;
	} else
	    return currentStation.name();
    }

    public int currentVolume() 
    {
	return this.volume;
    }


// MAIN
public static void main(String[] args) 
{

        FmRadioSet.addStationInfo(new RadioStationInfo("TSF", 105.3));
        FmRadioSet.addStationInfo(new RadioStationInfo("Comercial", 97.7));
        FmRadioSet.addStationInfo(new RadioStationInfo("Kiss", 88.8));

        FmRadioSet casio = new FmRadioSet(), 
                pionner = new FmRadioSet(), 
                sony = new FmRadioSet();
        
        casio.tune(97.7);
        casio.turnDownVolume();
        
        pionner.tune("TSF");
        
        sony.tune(casio.currentPlayingStation());
        sony.turnUpVolume();

        System.out.printf( "%s %d\n", casio.currentPlayingStation(), casio.currentVolume());
        System.out.printf( "%s %d\n", pionner.currentPlayingStation(), pionner.currentVolume());
        System.out.printf( "%s %d\n", sony.currentPlayingStation(), sony.currentVolume());

        casio.turnDownVolume();
        casio.tune(pionner.currentPlayingStation());
        System.out.printf( "%s %d\n", casio.currentPlayingStation(), casio.currentVolume());
        System.out.printf( "%s %d\n", pionner.currentPlayingStation(), pionner.currentVolume());
}
}
 
