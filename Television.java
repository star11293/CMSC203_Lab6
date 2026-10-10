// The purpose of this class is to model a television
// Akene Crosse 10/09/2026

/**
   The Television class keeps track of a TV's brand, screen size,
   power, channel and volume.
*/
public class Television
{
   private final String MANUFACTURER;  // the brand name, can't change
   private final int SCREEN_SIZE;      // the screen size in inches, can't change
   private boolean powerOn;            // true if the TV is on, false if it's off
   private int channel;                // the station the TV is showing
   private int volume;                 // how loud the TV is (0 = no sound)

   /**
      Creates a television with the given brand and screen size.
      The TV starts off, on channel 2, with the volume at 20.
      @param brand The manufacturer's brand name.
      @param size The screen size in inches.
   */
   public Television(String brand, int size)
   {
      MANUFACTURER = brand;
      SCREEN_SIZE = size;
      powerOn = false;
      volume = 20;
      channel = 2;
   }

   /**
      Changes the channel.
      @param station The channel to change to.
   */
   public void setChannel(int station)
   {
      channel = station;
   }

   /**
      Turns the power on if it's off, or off if it's on.
   */
   public void power()
   {
      powerOn = !powerOn;
   }

   /**
      Turns the volume up by 1.
   */
   public void increaseVolume()
   {
      volume++;
   }

   /**
      Turns the volume down by 1.
   */
   public void decreaseVolume()
   {
      volume--;
   }

   /**
      Gets the current channel.
      @return The channel.
   */
   public int getChannel()
   {
      return channel;
   }

   /**
      Gets the current volume.
      @return The volume.
   */
   public int getVolume()
   {
      return volume;
   }

   /**
      Gets the brand name.
      @return The manufacturer.
   */
   public String getManufacturer()
   {
      return MANUFACTURER;
   }

   /**
      Gets the screen size.
      @return The screen size in inches.
   */
   public int getScreenSize()
   {
      return SCREEN_SIZE;
   }
}
