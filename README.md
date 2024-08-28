# Telealerts

Telealerts is a simple tool designed to send alerts from your Linux boxes directly to your Telegram groups. Whether you're an engineer, self-hoster, or indie hacker, Telealerts provides the simplest way to keep you and your mates informed about the troubles in your services. It's just an executable with the only dependency on the glibc version, friendly to bash pipelining

## Usage

1. **Set up your configuration:**
   - Create a configuration file (e.g., `/etc/telealerts.conf`) with the following content:
     ```
     bot {
       id = "YOUR_TELEGRAM_BOT_ID"
       group_id = YOUR_TELEGRAM_GROUP_ID
     }
     ```
   - Replace `YOUR_TELEGRAM_BOT_ID` with your actual Telegram bot ID.
   - Replace `YOUR_TELEGRAM_GROUP_ID` with your actual Telegram group ID.

2. **Run the script:**
   - You can send a message directly:
     ```sh
     ./telealerts "Your alert message"
     ```
   - Or read from standard input:
     ```sh
     echo "Your alert message" | ./telealerts -stdin
     ```

## Building Instructions

For detailed instructions on how to build the project, please refer to [build.md](build.md). Graalvm is used to build the executable.




