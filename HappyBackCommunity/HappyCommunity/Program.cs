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

			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db;")) 
			{
				c.Open();
				String sql = "INSERT INTO FuckingLort (Navn) VALUES ('Mikkel Willis');";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					cmd.ExecuteNonQuery();
				}
			}


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
