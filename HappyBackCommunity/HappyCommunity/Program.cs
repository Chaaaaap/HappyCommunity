using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Data.Sqlite;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace HappyCommunity
{
	public class Program
	{
		public static void Main(string[] args)
		{
			// create a new database connection:
			SqliteConnection sqlite_conn =
			  new SqliteConnection("Data Source=HappyCommunity.db;");

			// open the connection:
			sqlite_conn.Open();
			SqliteCommand sqlite_cmd = sqlite_conn.CreateCommand();
			sqlite_cmd.CommandText = "INSERT INTO FuckingLort (Navn) VALUES ('Bruce Willis');";
			sqlite_cmd.ExecuteNonQuery();	
			CreateHostBuilder(args).Build().Run();
		}

		public static IHostBuilder CreateHostBuilder(string[] args) =>
			Host.CreateDefaultBuilder(args)
				.ConfigureWebHostDefaults(webBuilder =>
				{
					webBuilder.UseStartup<Startup>();
				});
	}
}
